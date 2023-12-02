export default function Footer() {
  return (
    <footer className="bg-black text-white body-font">
      <div className="container px-5 py-8 mx-auto flex items-center sm:flex-row flex-col">
        <a className="flex title-font font-medium items-center md:justify-start justify-center text-white">
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
        <p className="text-sm text-white sm:ml-4 sm:pl-4 sm:border-l-2 sm:border-gray-200 sm:py-2 sm:mt-0 mt-4">
          <a className="mr-5 hover:text-indigo-500">お問い合わせ</a>
          <a className="mr-5 hover:text-indigo-500">利用規約</a>
          <a className="mr-5 hover:text-indigo-500">プライバシーポリシー</a>
          <a className="mr-5 hover:text-indigo-500">ヘルプ</a>
        </p>
      </div>
    </footer>
  );
}
