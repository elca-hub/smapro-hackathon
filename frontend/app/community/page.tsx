import Communities from "@/components/Communities";
import Link from "next/link";

export default function CommunityTopPage() {
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

      <h2 className="sm:text-3xl text-2xl font-medium title-font text-gray-900 p-8">
        コミュニティ
      </h2>

      <section className="text-gray-600 body-font">
        <h2 className="sm:text-2xl sm:text-1xl font-medium title-font text-gray-900 p-8">
          所属コミュニティ一覧
        </h2>
        <div className="container px-1 py-1 mx-auto">
          <div className="flex flex-wrap sm:-m-4 -mx-4 -mb-10 -mt-4 md:space-y-0 px-4">
            <div className="lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
              <Communities></Communities>
            </div>
            <Link href={"community/belongingcommunities"}>
              <button className="inline-flex items-center bg-gray-100 border-0 px-7 focus:outline-none hover:bg-gray-200 rounded-full mt-12 w-14 h-14">
                ＞
              </button>
            </Link>
          </div>
        </div>
      </section>

      <section className="text-gray-600 body-font">
        <h2 className="sm:text-2xl sm:text-1xl font-medium title-font text-gray-900 p-8">
          おすすめのコミュニティ一覧
        </h2>
        <div className="container px-1 py-1 mx-auto">
          <div className="flex flex-wrap sm:-m-4 -mx-4 -mb-10 -mt-4 md:space-y-0 px-4">
            <div className="lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
              <Communities></Communities>
            </div>
            <Link href={"community/belongingcommunities"}>
              <button className="inline-flex items-center bg-gray-100 border-0 px-6 focus:outline-none hover:bg-gray-200 rounded-full mt-12 w-14 h-16">
                ＞
              </button>
            </Link>
          </div>
        </div>
      </section>
    </>
  );
}
