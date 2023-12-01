export default function Communities() {
  return (
    <div className="p-8 md:w-1/7 flex flex-col text-center items-center">
      <div className="w-20 h-20 inline-flex items-center justify-center rounded-full bg-indigo-100 text-indigo-500 mb-5 flex-shrink-0">
        <svg
          fill="none"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="2"
          className="w-10 h-10"
          viewBox="0 0 24 24"
        >
          <path d="M20 21v-2a4 4 0 00-4-4H8a4 4 0 00-4 4v2"></path>
          <circle cx="12" cy="7" r="4"></circle>
        </svg>
      </div>
      <div className="flex-grow">
        <h2 className="text-gray-900 text-lg title-font font-medium mb-3">
          タイトル
        </h2>
        <svg
          fill="none"
          stroke="currentColor"
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="2"
          className="w-4 h-4 ml-2"
          viewBox="0 0 24 24"
        ></svg>
      </div>
    </div>
  );
}
