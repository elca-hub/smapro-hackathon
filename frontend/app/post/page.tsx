"use client";

import Articles from "@/components/Articles";
import Link from "next/link";
import AuthRequest from "@/request/AuthRequest";
import AuthResponse from "@/request/model/AuthResponse";
import { BsChevronDoubleRight } from "react-icons/bs";
import { BsFillSendPlusFill } from "react-icons/bs";
import { useState, useEffect } from "react";
import AuthToken from "@/request/model/AuthToken";

const authRequest: AuthRequest = new AuthRequest(new AuthToken());

type Article = {
  id: string;
  title: string;
  content: string;
  reactionCount: number;
};

const fetchArticles = async (): Promise<Article[]> => {
  const res: AuthResponse = await authRequest.request("article/", "GET");
  const data = res.json;
  if (data.status === "SUCCESS" && res.status === 200) {
    const articleData = data.data;
    return articleData.map((article: any) => {
      const values: number[] = Object.values(article.evaluations);

      return {
        id: article.articleId,
        title: article.title,
        content: article.content,
        reactionCount: values.reduce(
          (sum: number, ele: number) => sum + ele,
          0
        ),
      };
    });
  }

  throw new Error("failed to fetch articles.");
};

export default function ArticleTopPage() {
  const [articles, setArticles] = useState<Article[]>([]);

  useEffect(() => {
    (async () => {
      const data = await fetchArticles();
      setArticles(data);
    })();
  }, []);

  return (
    <>
      <h2 className="sm:text-3xl text-2xl font-medium title-font text-gray-900 p-8">
        投稿ページ
      </h2>

      <section className="text-gray-600 body-font pl-8">
        <h2 className="sm:text-2xl sm:text-1xl font-medium title-font text-gray-900 p-8">
          投稿する
        </h2>
        <div className="container px-10 pt-4">
          <Link href="post/create">
            <button className="w-16 h-16 mr-3 inline-flex items-center justify-center rounded-full bg-indigo-500 hover:bg-indigo-600 text-white text-3xl flex-shrink-0">
              <BsFillSendPlusFill />
            </button>
          </Link>
        </div>
      </section>

      <section className="text-gray-600 body-font pl-8">
        <h2 className="sm:text-2xl sm:text-1xl font-medium title-font text-gray-900 p-8">
          投稿した記事一覧
        </h2>
        <div className="container px-5 py-4 mx-auto">
          <div className="-m-4 mb-8">
            <div className="flex flex-wrap lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto items-center">
              {articles.map((article) => {
                return (
                  <Articles
                    title={article.title}
                    key={article.id}
                    id={""}
                  ></Articles>
                );
              })}
              <Link href="post/pastposts">
                <button className="w-12 h-12 mr-3 inline-flex items-center justify-center rounded-full bg-indigo-500 hover:bg-indigo-600 text-white flex-shrink-0">
                  <BsChevronDoubleRight />
                </button>
              </Link>
            </div>
          </div>
        </div>
      </section>
    </>
  );
}
