import Articles from "@/components/Articles";
import Link from "next/link";

export default function PostTopPage() {
  return (
    <>
      <h2 className="sm:text-3xl text-2xl font-medium title-font text-gray-900 p-8">
        投稿ページ
      </h2>

      <section className="text-gray-600 body-font">
        <h2 className="sm:text-2xl sm:text-1xl font-medium title-font text-gray-900 p-8">
          投稿する
        </h2>
        <div className="container px-5 py-4 mx-auto">
          <button className="inline-flex items-center bg-gray-100 border-0 px-6 focus:outline-none hover:bg-gray-200 rounded-full w-14 h-14">
            +
          </button>
        </div>
      </section>

      <section className="text-gray-600 body-font">
        <h2 className="sm:text-2xl sm:text-1xl font-medium title-font text-gray-900 p-8">
          過去の投稿記事一覧
        </h2>
        <div className="container px-5 py-4 mx-auto">
          <div className="flex flex-wrap -m-4">
            <div className="lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
              <Articles></Articles>
            </div>
            <Link href="post/pastposts">
              <button className="inline-flex items-center bg-gray-100 border-0 px-6 focus:outline-none hover:bg-gray-200 rounded-full mt-20 w-14 h-14">
                ＞
              </button>
            </Link>
          </div>
        </div>
      </section>
    </>
  );
}
