import Articles from "@/components/Articles";
import Link from "next/link";
import { BsChevronDoubleRight } from "react-icons/bs";
import { BsFilePlus } from "react-icons/bs";

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
          <button className="w-16 h-16 mr-3 inline-flex items-center justify-center rounded-full bg-indigo-500 text-white text-3xl flex-shrink-0">
          <BsFilePlus />
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
              <button className="w-12 h-12 mr-3 mt-20 inline-flex items-center justify-center rounded-full bg-indigo-500 text-white flex-shrink-0">
                <BsChevronDoubleRight />
              </button>
            </Link>
          </div>
        </div>
      </section>
    </>
  );
}
