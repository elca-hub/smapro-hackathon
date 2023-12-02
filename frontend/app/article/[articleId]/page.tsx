"use client";

import AuthRequest from "@/request/AuthRequest";
import AuthResponse from "@/request/model/AuthResponse";
import AuthToken from "@/request/model/AuthToken";
import { useState, useEffect } from "react";
import { BsSuitHeart } from "react-icons/bs";
import { BsFillHandThumbsUpFill } from "react-icons/bs";
import { BsFillPenFill } from "react-icons/bs";
import { BsFillHandThumbsDownFill } from "react-icons/bs";
import { BsPatchExclamation } from "react-icons/bs";

const authRequest: AuthRequest = new AuthRequest(new AuthToken());

type Article = {
  id: string;
  title: string;
  content: string;
};

const fetchArticles = async (articleId: string): Promise<Article> => {
  const res: AuthResponse = await authRequest.request(
    `article/${articleId}`,
    "GET"
  );
  const data = res.json;
  if (data.status === "SUCCESS" && res.status === 200) {
    const articleData = data.data;

    return {
      id: articleData.articleId,
      title: articleData.title,
      content: articleData.content,
    };
  }

  throw new Error("failed to fetch articles.");
};

export default function ViexArticle({
  params,
}: {
  params: { articleId: string };
}) {
  const [article, setArticle] = useState<Article>();

  useEffect(() => {
    const articleId = params.articleId;
    (async () => {
      const data = await fetchArticles(articleId);
      setArticle(data);
    })();
  }, [params]);

  return (
    <section className="text-gray-600 body-font overflow-hidden">
      <div className="container px-5 py-24 mx-auto">
        <div className="lg:w-4/5 mx-auto flex flex-wrap">
          <div className="lg:w-1/2 w-full lg:pr-10 lg:py-6 mb-6 lg:mb-0">
            <h2 className="text-sm title-font text-gray-500 tracking-widest">
              最終更新日時
            </h2>
            <h1 className="text-gray-900 text-3xl title-font font-medium mb-4">
              {article?.title}
            </h1>
            <p className="leading-relaxed mb-4">{article?.content}</p>
            <div className="flex border-t border-gray-200 py-2">
              <span className="text-gray-500">いいね！</span>
              <span className="ml-auto text-gray-900">16</span>
            </div>
            <div className="flex border-t border-gray-200 py-2">
              <span className="text-gray-500">助かりました！</span>
              <span className="ml-auto text-gray-900">45</span>
            </div>
            <div className="flex border-t border-b  border-gray-200 py-2">
              <span className="text-gray-500">正しいです</span>
              <span className="ml-auto text-gray-900">30</span>
            </div>
            <div className="flex border-t border-b  border-gray-200 py-2">
              <span className="text-gray-500">間違っています</span>
              <span className="ml-auto text-gray-900">30</span>
            </div>
            <div className="flex border-t border-b mb-8 border-gray-200 py-2">
              <span className="text-gray-500">意外</span>
              <span className="ml-auto text-gray-900">30</span>
            </div>
            <div className="flex">
              <span className="title-font font-medium text-2xl text-gray-900">
                リアクションを追加する
              </span>
              <button className="rounded-full w-10 h-10 bg-gray-200 p-0 border-0 inline-flex items-center justify-center text-gray-500 ml-4">
                <BsSuitHeart />
              </button>
              <button className="rounded-full w-10 h-10 bg-gray-200 p-0 border-0 inline-flex items-center justify-center text-gray-500 ml-4">
                <BsFillPenFill />
              </button>
              <button className="rounded-full w-10 h-10 bg-gray-200 p-0 border-0 inline-flex items-center justify-center text-gray-500 ml-4">
                <BsFillHandThumbsUpFill />
              </button>
              <button className="rounded-full w-10 h-10 bg-gray-200 p-0 border-0 inline-flex items-center justify-center text-gray-500 ml-4">
                <BsFillHandThumbsDownFill />
              </button>
              <button className="rounded-full w-10 h-10 bg-gray-200 p-0 border-0 inline-flex items-center justify-center text-gray-500 ml-4">
                <BsPatchExclamation />
              </button>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
}
