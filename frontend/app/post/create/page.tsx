"use client";

import AuthRequest from "@/request/AuthRequest";
import AuthResponse from "@/request/model/AuthResponse";
import AuthToken from "@/request/model/AuthToken";
import { useRouter } from "next/navigation";
import { FormEvent, useEffect, useState } from "react";

type Community = {
  id: string;
  name: string;
};

const authRequest = new AuthRequest(new AuthToken());

const fetchCommunities = async (): Promise<Community[]> => {
  const res: AuthResponse = await authRequest.request("community/", "GET");
  const data = res.json;
  if (data.status === "SUCCESS" && res.status === 200) {
    const communityData = data.data;
    return communityData.map((community: any) => {
      return {
        id: community.communityId,
        name: community.name,
      };
    });
  }

  throw new Error("failed to fetch community");
};

export default function CreateArticlePage() {
  const router = useRouter();
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const [community, setCommunity] = useState("");

  const [communities, setCommunities] = useState<Community[]>([]);

  useEffect(() => {
    (async () => {
      const data = await fetchCommunities();

      setCommunities(data);
    })();
  }, []);

  async function onSubmit(e: FormEvent<HTMLFormElement>) {
    e.preventDefault();

    const sendData = {
      title,
      content,
      communityId: community.length > 0 ? community : null,
    };

    const token = localStorage.getItem("token");

    if (!token) {
      router.push("/signin");
      return;
    }

    const res = await authRequest.request("article/", "POST", sendData);

    const data = res.json;
    const status = res.status;

    if (data.status === "SUCCESS" && status === 200) {
      router.push("/article");
      return;
    } else {
      if (status === 200 && data.status === "ERROR") {
        alert(data.message);
        return;
      } else {
        alert("エラーが発生しました");
        return;
      }
    }
  }

  return (
    <>
      <h2 className="sm:text-3xl text-2xl font-medium title-font text-gray-900 p-8">
        記事の作成
      </h2>

      <div className="px-6">
        <form onSubmit={onSubmit}>
          <div className="mb-3">
            <label className="block text-gray-700 text-sm font-bold mb-2">
              タイトル
            </label>
            <input
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight"
              id="title"
              type="text"
              placeholder="タイトル"
              value={title}
              onChange={(e) => setTitle(e.target.value)}
              required
            ></input>
          </div>

          <div className="mb-3">
            <label className="block text-gray-700 text-sm font-bold mb-2">
              内容
            </label>
            <textarea
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight"
              id="content"
              placeholder="内容"
              value={content}
              onChange={(e) => setContent(e.target.value)}
              required
            ></textarea>
          </div>

          <div className="mb-3">
            <label className="block text-gray-700 text-sm font-bold mb-2">
              コミュニティ
            </label>
            <select
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight"
              id="community"
              value={community}
              onChange={(e) => setCommunity(e.target.value)}
            >
             <option value="">選択してください</option>
              {communities.map((community) => {
                return (
                  <option value={community.id} key={community.id}>
                    {community.name}
                  </option>
                );
              })}
            </select>
          </div>

          <div className="text-center my-6">
            <button
              className="bg-indigo-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
              type="submit"
            >
              投稿する
            </button>
          </div>
        </form>
      </div>
    </>
  );
}
