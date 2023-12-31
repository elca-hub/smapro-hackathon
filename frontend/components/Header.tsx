"use client";

import AuthRequest from "@/request/AuthRequest";
import AuthToken from "@/request/model/AuthToken";

export default function Header() {
  async function logout() {
    const authRequest = new AuthRequest(new AuthToken());
    
    const res = await authRequest.request("user/logout", "GET");
    const data = res.json;
    if (data.status === "SUCCESS" && res.status === 200) {
      localStorage.removeItem("token");
      location.href = "/";
    }
  }

  return (
    <header className="bg-black text-white body-font">
      <div className="container mx-auto flex flex-wrap p-5 flex-col md:flex-row items-center">
        <a
          href="http://localhost:3000"
          className="flex title-font font-medium items-center text-white mb-4 md:mb-0"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            stroke="currentColor"
            strokeLinecap="round"
            strokeLinejoin="round"
            strokeWidth="2"
            className="w-10 h-10 text-white p-2 bg-indigo-500 rounded-full"
            viewBox="0 0 24 24"
          >
            <path d="M12 2L2 7l10 5 10-5-10-5zM2 17l10 5 10-5M2 12l10 5 10-5"></path>
          </svg>
          <span className="ml-3 text-xl">あーぷっと</span>
        </a>
        <nav className="md:ml-auto md:mr-auto flex flex-wrap items-center text-base justify-center">
          <a href="/home" className="mr-5 hover:text-indigo-500">
            ホーム
          </a>
          <a href="/post" className="mr-5 hover:text-indigo-500">
            投稿する
          </a>
          <a href="/article" className="mr-5 hover:text-indigo-500">
            記事一覧
          </a>
          <a href="/community" className="mr-5 hover:text-indigo-500">
            コミュニティ
          </a>
          <a className="mr-5 hover:text-indigo-500" onClick={logout}>
            ログアウト
          </a>
          {/* <a className="mr-5 hover:text-text-indigo-500">お知らせ</a> */}
        </nav>
        <svg
          fill="none"
          stroke="currentColor"
          strokeLinecap="round"
          strokeLinejoin="round"
          strokeWidth="2"
          className="w-10 h-10"
          viewBox="0 0 24 24"
        >
          <path d="M20 21v-2a4 4 0 00-4-4H8a4 4 0 00-4 4v2"></path>
          <circle cx="12" cy="7" r="4"></circle>
        </svg>
      </div>
    </header>
  );
}
