import Image from 'next/image'
import { Router } from 'next/router'

export default function Home() {
  return (

  <><header className="text-gray-600 body-font">
      <div className="container mx-auto flex flex-wrap p-5 flex-col md:flex-row items-center">
        <a className="flex title-font font-medium items-center text-gray-900 mb-4 md:mb-0">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-10 h-10 text-white p-2 bg-indigo-500 rounded-full" viewBox="0 0 24 24">
            <path d="M12 2L2 7l10 5 10-5-10-5zM2 17l10 5 10-5M2 12l10 5 10-5"></path>
          </svg>
          <span className="ml-3 text-xl">apt</span>
        </a>
        <nav className="md:ml-auto md:mr-auto flex flex-wrap items-center text-base justify-center">
          <a className="mr-5 hover:text-gray-900">ホーム</a>
          <a className="mr-5 hover:text-gray-900">投稿する</a>
          <a className="mr-5 hover:text-gray-900">記事一覧</a>
          <a className="mr-5 hover:text-gray-900">コミュニティ</a>
        </nav>
        <button className="inline-flex items-center bg-gray-100 border-0 py-3 px-5 focus:outline-none hover:bg-gray-200 rounded-full mt-4 md:mt-0">i</button>
      </div>
    </header>

    <section className="text-gray-600 body-font">
      <div className="container px-5 py-24 mx-auto">
        <div className="flex flex-col text-center w-full mb-10">
          <h2 className="text-xs text-indigo-500 tracking-widest font-medium title-font mb-1">勉強アウトプットアプリ</h2>
          <h1 className="sm:text-3xl text-2xl font-medium title-font text-gray-900">あーぷっと</h1>
        </div>
        <div className="flex justify-center pb-20">
          <button className="inline-flex text-white bg-indigo-500 border-0 py-2 px-6 focus:outline-none hover:bg-indigo-600 rounded text-lg">サインイン</button>
          <button className="ml-4 inline-flex text-gray-700 bg-gray-100 border-0 py-2 px-6 focus:outline-none hover:bg-gray-200 rounded text-lg">サインアップ</button>
        </div>
        <h2 className="sm:text-3xl text-2xl font-medium title-font text-gray-900 pb-8">あーぷっととは？</h2>
        <div className="flex flex-wrap -m-4">
          <div className="p-4 md:w-1/3">
            <div className="flex rounded-lg h-full bg-gray-100 p-8 flex-col">
              <div className="flex items-center mb-3">
                <div className="w-8 h-8 mr-3 inline-flex items-center justify-center rounded-full bg-indigo-500 text-white flex-shrink-0">
                  <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-5 h-5" viewBox="0 0 24 24">
                    <path d="M22 12h-4l-3 9L9 3l-3 9H2"></path>
                  </svg>
                </div>
                <h2 className="text-gray-900 text-lg title-font font-medium">記事の投稿機能</h2>
              </div>
              <div className="flex-grow">
                <p className="leading-relaxed text-base">説明をここに記入</p>
                <a className="mt-3 text-indigo-500 inline-flex items-center">投稿ページはこちら
                  <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-4 h-4 ml-2" viewBox="0 0 24 24">
                    <path d="M5 12h14M12 5l7 7-7 7"></path>
                  </svg>
                </a>
              </div>
            </div>
          </div>
          <div className="p-4 md:w-1/3">
            <div className="flex rounded-lg h-full bg-gray-100 p-8 flex-col">
              <div className="flex items-center mb-3">
                <div className="w-8 h-8 mr-3 inline-flex items-center justify-center rounded-full bg-indigo-500 text-white flex-shrink-0">
                  <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-5 h-5" viewBox="0 0 24 24">
                    <path d="M20 21v-2a4 4 0 00-4-4H8a4 4 0 00-4 4v2"></path>
                    <circle cx="12" cy="7" r="4"></circle>
                  </svg>
                </div>
                <h2 className="text-gray-900 text-lg title-font font-medium">記事の閲覧機能</h2>
              </div>
              <div className="flex-grow">
                <p className="leading-relaxed text-base">ここに説明を記入</p>
                <a className="mt-3 text-indigo-500 inline-flex items-center">記事一覧ページはこちら
                  <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-4 h-4 ml-2" viewBox="0 0 24 24">
                    <path d="M5 12h14M12 5l7 7-7 7"></path>
                  </svg>
                </a>
              </div>
            </div>
          </div>
          <div className="p-4 md:w-1/3">
            <div className="flex rounded-lg h-full bg-gray-100 p-8 flex-col">
              <div className="flex items-center mb-3">
                <div className="w-8 h-8 mr-3 inline-flex items-center justify-center rounded-full bg-indigo-500 text-white flex-shrink-0">
                  <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-5 h-5" viewBox="0 0 24 24">
                    <circle cx="6" cy="6" r="3"></circle>
                    <circle cx="6" cy="18" r="3"></circle>
                    <path d="M20 4L8.12 15.88M14.47 14.48L20 20M8.12 8.12L12 12"></path>
                  </svg>
                </div>
                <h2 className="text-gray-900 text-lg title-font font-medium">コミュニティ機能</h2>
              </div>
              <div className="flex-grow">
                <p className="leading-relaxed text-base">ここに説明を記入</p>
                <a className="mt-3 text-indigo-500 inline-flex items-center">コミュニティページはこちら
                  <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-4 h-4 ml-2" viewBox="0 0 24 24">
                    <path d="M5 12h14M12 5l7 7-7 7"></path>
                  </svg>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section className="text-gray-600 body-font">
      <div className="container px-5 py-24 mx-auto">
        <div className="flex flex-col text-center w-full mb-20">
          <h2 className="sm:text-4xl text-3xl font-medium title-font mb-2 text-gray-900">お知らせ一覧</h2>
        </div>
        <div className="lg:w-2/3 w-full mx-auto overflow-auto">
          <table className="table-auto w-full text-left whitespace-no-wrap">
            <thead>
              <tr>
                <th className="px-4 py-3 title-font tracking-wider font-medium text-gray-900 text-sm bg-gray-100 rounded-tl rounded-bl">更新日時</th>
                <th className="px-4 py-3 title-font tracking-wider font-medium text-gray-900 text-sm bg-gray-100">タイトル</th>
                <th className="w-10 title-font tracking-wider font-medium text-gray-900 text-sm bg-gray-100 rounded-tr rounded-br"></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td className="px-4 py-3">2023/11/29</td>
                <td className="px-4 py-3">トップページを作成しました。</td>
              </tr>
              <tr>
                <td className="border-t-2 border-gray-200 px-4 py-3">2023/11/28</td>
                <td className="border-t-2 border-gray-200 px-4 py-3">ここにお知らせを記入する。</td>
              </tr>
              <tr>
                <td className="border-t-2 border-gray-200 px-4 py-3">2023/11/28</td>
                <td className="border-t-2 border-gray-200 px-4 py-3">ここにお知らせを記入する。</td>
              </tr>
              <tr>
                <td className="border-t-2 border-b-2 border-gray-200 px-4 py-3">2023/11/27</td>
                <td className="border-t-2 border-b-2 border-gray-200 px-4 py-3">ここにお知らせを記入する。</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </section>

    <footer className="text-gray-600 body-font">
      <div className="container px-5 py-8 mx-auto flex items-center sm:flex-row flex-col">
        <a className="flex title-font font-medium items-center md:justify-start justify-center text-gray-900">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-10 h-10 text-white p-2 bg-indigo-500 rounded-full" viewBox="0 0 24 24">
            <path d="M12 2L2 7l10 5 10-5-10-5zM2 17l10 5 10-5M2 12l10 5 10-5"></path>
          </svg>
          <span className="ml-3 text-xl">apt</span>
        </a>
        <p className="text-sm text-gray-500 sm:ml-4 sm:pl-4 sm:border-l-2 sm:border-gray-200 sm:py-2 sm:mt-0 mt-4">
          <a className="mr-5 hover:text-gray-900">お問い合わせ</a>
          <a className="mr-5 hover:text-gray-900">利用規約</a>
          <a className="mr-5 hover:text-gray-900">プライバシーポリシー</a>
          <a className="mr-5 hover:text-gray-900">ヘルプ</a>
        </p>
      </div>
    </footer>
  </>

  )
}
