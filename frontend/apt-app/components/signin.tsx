import Image from 'next/image'

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
