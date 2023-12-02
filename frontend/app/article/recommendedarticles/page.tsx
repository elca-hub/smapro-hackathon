"use client";

import Articles from "@/components/Articles";
import AuthRequest from "@/request/AuthRequest";
import AuthResponse from "@/request/model/AuthResponse";
import AuthToken from "@/request/model/AuthToken";
import { useState, useEffect } from "react";

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

export default function RecommendArticlePage() {
  const [articles, setArticles] = useState<Article[]>([]);

  useEffect(() => {
    (async () => {
      const data = await fetchArticles();
      setArticles(data);
    })();
  }, []);

  return (
    <>
      <label className="relative block px-52 mt-6">
        <span className="sr-only">Search</span>
        <span className="absolute inset-y-0 left-0 flex items-center pl-2">
          <svg className="h-5 w-5 fill-slate-300" viewBox="0 0 20 20"></svg>
        </span>
        <input
          className="placeholder:italic placeholder:text-slate-400 block bg-white w-full border border-slate-300 rounded-md py-2 pl-9 pr-3 shadow-sm focus:outline-none focus:border-sky-500 focus:ring-sky-500 focus:ring-1 sm:text-sm"
          placeholder="検索"
          type="text"
          name="search"
        />
      </label>

      <section className="text-gray-600 body-font">
        <h2 className="sm:text-2xl sm:text-1xl font-medium title-font text-gray-900 p-8">
          おすすめの記事一覧
        </h2>
        <div className="container px-5 py-4 mx-auto">
          <div className="flex flex-wrap -m-4">
            {articles.map((article) => {
              return (
                <Articles
                  title={article.title}
                  key={article.id}
                  id={""}
                ></Articles>
              );
            })}
          </div>
        </div>
      </section>
    </>
  );
}
