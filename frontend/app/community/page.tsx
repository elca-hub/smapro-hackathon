"use client";

import Communities from "@/components/Communities";
import AuthRequest from "@/request/AuthRequest";
import AuthResponse from "@/request/model/AuthResponse";
import AuthToken from "@/request/model/AuthToken";
import Link from "next/link";
import { useState, useEffect, FormEvent } from "react";
import { BsChevronDoubleRight } from "react-icons/bs";
import { BsFillPersonPlusFill } from "react-icons/bs";

type Community = {
  id: string;
  name: string;
  member: number;
}


const fetchCommunities = async (): Promise<Community[]> => {
  const authRequest = new AuthRequest(new AuthToken());

  const res: AuthResponse = await authRequest.request("community/", "GET");
  const data = res.json;

  if (data.status === "SUCCESS" && res.status === 200) {
    const communityData = data.data;
    return communityData.map((community: any) => {
      return {
        id: community.communityId,
        name: community.name,
        member: community.memberCount,
      };
    });
  } else {
    alert("エラーが発生しました");
    throw new Error("failed to fetch community");
  }
}

export default function CommunityTopPage() {
  const authRequest = new AuthRequest(new AuthToken());
  const [communities, setCommunities] = useState<Community[]>([]);
  const [entryCode, setEntryCode] = useState("");
  const [community, setCommunity] = useState<Community>();

  useEffect(() => {
    (async () => {
      const data = await fetchCommunities();
      setCommunities(data);
    })();
  }, []);

  async function onSubmit(e: FormEvent<HTMLFormElement>) {
    e.preventDefault();

    const sendData = {
      entryCode,
    };

    const res: AuthResponse = await authRequest.request(
      "community/entry",
      "POST",
      sendData
    );

    const data = res.json;

    if (data.status === "SUCCESS" && res.status === 200) {
      const communityData = data.data;

      setCommunity({
        id: communityData.id,
        name: communityData.name,
        member: -1
      });
    } else {
      setCommunity(undefined);
    }
  }

  async function joinCommunity() {
    const sendData = {
      entryCode,
      communityId: community?.id
    };

    console.log(sendData);

    const res: AuthResponse = await authRequest.request(
      "community/join",
      "POST",
      sendData
    );

    const data = res.json;

    console.log(data);

    if (data.status === "SUCCESS" && res.status === 200) {
      setEntryCode("");
      const data = await fetchCommunities();
      setCommunities(data);
    }

    setCommunity(undefined);
  }

  return (
    <>
      <label className="relative block px-52 mt-6">
        <span className="sr-only">Search</span>
        <span className="absolute inset-y-0 left-0 flex items-center pl-2">
          <svg className="h-5 w-5 fill-slate-300" viewBox="0 0 20 20"></svg>
        </span>
        <form onSubmit={onSubmit}>
          <input
            className="placeholder:italic placeholder:text-slate-400 block bg-white w-full border border-slate-300 rounded-md py-2 pl-9 pr-3 shadow-sm focus:outline-none focus:border-sky-500 focus:ring-sky-500 focus:ring-1 sm:text-sm"
            placeholder="参加コードを入力"
            type="text"
            name="search"
            id="search"
            value={entryCode}
            onChange={(e) => setEntryCode(e.target.value)}
          />

          <div className="absolute inset-y-0 right-0 flex items-center pr-3">
            <button
              type="submit"
              className="bg-sky-500 hover:bg-sky-700 text-white font-bold py-2 px-4 rounded-full"
            >
              参加
            </button>
          </div>
        </form>
      </label>

      <div className={`${community ? 'block' : 'hidden'} text-center mt-3`}>
        <h4>以下のコミュニティが見つかりました。</h4>
        <h3 className="my-3">{community?.name}</h3>

        <button className="bg-sky-500 hover:bg-sky-700 text-white font-bold py-2 px-4 rounded-full" onClick={joinCommunity}>
          参加する
        </button>
      </div>

      <h2 className="sm:text-3xl text-2xl font-medium title-font text-gray-900 p-8">
        コミュニティ
      </h2>

      <section className="text-gray-600 body-font">
        <h2 className="sm:text-2xl sm:text-1xl font-medium title-font text-gray-900 p-8">
          コミュニティを作成する
        </h2>
        <div className="container px-10 py-4">
          <Link href="community/create">
            <button className="w-16 h-16 mr-3 inline-flex items-center justify-center rounded-full bg-indigo-500 text-white text-3xl flex-shrink-0">
              <BsFillPersonPlusFill />
            </button>
          </Link>
        </div>
      </section>

      <section className="text-gray-600 body-font">
        <h2 className="sm:text-2xl sm:text-1xl font-medium title-font text-gray-900 p-8">
          所属コミュニティ一覧
        </h2>
        <div className="container px-1 py-1 mx-auto">
          <div className="flex flex-wrap sm:-m-4 -mx-4 -mb-10 -mt-4 md:space-y-0 px-4 items-center">
            <div className="flex lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
              {communities.map((community) => {
                return (
                  <Communities
                    title={community.name}
                    number={community.member}
                    id={community.id}
                    key={community.id}
                  ></Communities>
                );
              })}
            </div>
            <Link href={"community/belongingcommunities"}>
              <button className="w-12 h-12 mr-3 inline-flex items-center justify-center rounded-full bg-indigo-500 text-white flex-shrink-0">
                <BsChevronDoubleRight />
              </button>
            </Link>
          </div>
        </div>
      </section>
    </>
  );
}
