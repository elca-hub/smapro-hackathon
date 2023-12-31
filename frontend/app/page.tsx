import Link from "next/link";
import { BsFileEarmarkPlus } from "react-icons/bs";
import { BsJournalRichtext } from "react-icons/bs";
import { BsFillPersonPlusFill } from "react-icons/bs";

export default function TopPage() {
  return (
    <>
      <section className="text-gray-600 body-font">
        <div className="container px-5 py-24 mx-auto">
          <div className="flex flex-col text-center w-full mb-10">
            <h2 className="text-xs text-indigo-500 tracking-widest font-medium title-font mb-1">
              勉強アウトプットアプリ
            </h2>
            <h1 className="sm:text-5xl text-4xl font-medium title-font text-gray-900">
              あーぷっと
            </h1>
          </div>
          <div className="flex justify-center pb-20">
            <Link href="signin">
              <button className="inline-flex text-white bg-indigo-500 border-0 py-2 px-6 focus:outline-none hover:bg-indigo-600 rounded text-lg">
                サインイン
              </button>
            </Link>
            <Link href="signup">
              <button className="ml-4 inline-flex text-gray-700 bg-gray-100 border-0 py-2 px-6 focus:outline-none hover:bg-gray-200 rounded text-lg">
                サインアップ
              </button>
            </Link>
          </div>
          <h2 className="sm:text-4xl text-3xl font-medium title-font text-center text-gray-900 pb-8">
            あーぷっとの機能
          </h2>
          <div className="flex flex-wrap -m-4">
            <div className="p-4 md:w-1/3">
              <div className="flex rounded-lg h-full bg-gray-100 p-8 flex-col">
                <div className="flex items-center mb-3">
                  <div className="w-8 h-8 mr-3 inline-flex items-center justify-center rounded-full bg-indigo-500 text-white flex-shrink-0">
                    <BsFileEarmarkPlus />
                  </div>
                  <h2 className="text-gray-900 text-lg title-font font-medium">
                    記事の投稿機能
                  </h2>
                </div>
                <div className="flex-grow">
                  <p className="leading-relaxed text-base">
                    自身が勉強したことを記事にして投稿できます。投稿した記事は多くの人が閲覧でき、評価をしてくれます。
                  </p>
                  <a
                    href="post"
                    className="mt-3 text-indigo-500 hover:text-indigo-600 inline-flex items-center"
                  >
                    投稿ページはこちら
                    <svg
                      fill="none"
                      stroke="currentColor"
                      strokeLinecap="round"
                      strokeLinejoin="round"
                      strokeWidth="2"
                      className="w-4 h-4 ml-2"
                      viewBox="0 0 24 24"
                    >
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
                    <BsJournalRichtext />
                  </div>
                  <h2 className="text-gray-900 text-lg title-font font-medium">
                    記事の閲覧機能
                  </h2>
                </div>
                <div className="flex-grow">
                  <p className="leading-relaxed text-base">
                    他の人の記事を閲覧できます。記事を通して、自身の知見を深めることやリアクションで評価することができます。
                  </p>
                  <a
                    href="article"
                    className="mt-3 text-indigo-500 hover:text-indigo-600 inline-flex items-center"
                  >
                    記事一覧ページはこちら
                    <svg
                      fill="none"
                      stroke="currentColor"
                      strokeLinecap="round"
                      strokeLinejoin="round"
                      strokeWidth="2"
                      className="w-4 h-4 ml-2"
                      viewBox="0 0 24 24"
                    >
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
                    <BsFillPersonPlusFill />
                  </div>
                  <h2 className="text-gray-900 text-lg title-font font-medium">
                    コミュニティ機能
                  </h2>
                </div>
                <div className="flex-grow">
                  <p className="leading-relaxed text-base">
                    多くのコミュニティに参加することができます。同じ学校で同じことを勉強している仲間を見つけ、自身の勉強の効率を高めていきましょう。
                  </p>
                  <a
                    href="community"
                    className="mt-3 text-indigo-500 hover:text-indigo-600 inline-flex items-center"
                  >
                    コミュニティページはこちら
                    <svg
                      fill="none"
                      stroke="currentColor"
                      strokeLinecap="round"
                      strokeLinejoin="round"
                      strokeWidth="2"
                      className="w-4 h-4 ml-2"
                      viewBox="0 0 24 24"
                    >
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
            <h2 className="sm:text-4xl text-3xl font-medium title-font mb-2 text-gray-900">
              お知らせ一覧
            </h2>
          </div>
          <div className="lg:w-2/3 w-full mx-auto overflow-auto">
            <table className="table-auto w-full text-left whitespace-no-wrap">
              <thead>
                <tr>
                  <th className="px-4 py-3 title-font tracking-wider font-medium text-gray-900 text-sm bg-gray-100 rounded-tl rounded-bl">
                    更新日時
                  </th>
                  <th className="px-4 py-3 title-font tracking-wider font-medium text-gray-900 text-sm bg-gray-100">
                    タイトル
                  </th>
                  <th className="w-10 title-font tracking-wider font-medium text-gray-900 text-sm bg-gray-100 rounded-tr rounded-br"></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td className="px-4 py-3">2023/12/3</td>
                  <td className="px-4 py-3">ウェブページのUIを改善しました。</td>
                </tr>
                <tr>
                  <td className="border-t-2 border-gray-200 px-4 py-3">
                    2023/12/2
                  </td>
                  <td className="border-t-2 border-gray-200 px-4 py-3">
                    コミュニティの作成機能を実装しました。
                  </td>
                </tr>
                <tr>
                  <td className="border-t-2 border-gray-200 px-4 py-3">
                    2023/12/2
                  </td>
                  <td className="border-t-2 border-gray-200 px-4 py-3">
                    記事の投稿機能を実装しました。
                  </td>
                </tr>
                <tr>
                  <td className="border-t-2 border-gray-200 px-4 py-3">
                    2023/12/2
                  </td>
                  <td className="border-t-2 border-gray-200 px-4 py-3">
                    スマプロハッカソン１日目
                  </td>
                </tr>
                <tr>
                  <td className="border-t-2 border-b-2 border-gray-200 px-4 py-3">
                    2023/11/27
                  </td>
                  <td className="border-t-2 border-b-2 border-gray-200 px-4 py-3">
                    あーぷっとのページを作成しました。
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </section>
    </>
  );
}
