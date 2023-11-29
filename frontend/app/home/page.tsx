import Link from 'next/link';

export default function Home() {
    return (
        <>
            <label className="relative block px-52 mt-6">
                <span className="sr-only">Search</span>
                <span className="absolute inset-y-0 left-0 flex items-center pl-2">
                    <svg className="h-5 w-5 fill-slate-300" viewBox="0 0 20 20"></svg>
                </span>
                <input className="placeholder:italic placeholder:text-slate-400 block bg-white w-full border border-slate-300 rounded-md py-2 pl-9 pr-3 shadow-sm focus:outline-none focus:border-sky-500 focus:ring-sky-500 focus:ring-1 sm:text-sm" placeholder="検索" type="text" name="search"/>
            </label>

            <h2 className="sm:text-3xl text-2xl font-medium title-font text-gray-900 p-8">ホーム</h2>

            <section className="text-gray-600 body-font">
                <h2 className="sm:text-2xl sm:text-1xl font-medium title-font text-gray-900 p-8">おすすめの記事一覧</h2>
                <div className="container px-5 py-4 mx-auto">
                    <div className="flex flex-wrap -m-4">
                        <div className="lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
                            <a className="block relative h-48 rounded overflow-hidden">
                                <img alt="ecommerce" className="object-cover object-center w-full h-full block" src="https://dummyimage.com/210x297"></img>
                            </a>
                            <div className="mt-4">
                                <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">作成日</h3>
                                <h2 className="text-gray-900 title-font text-lg font-medium">タイトル</h2>
                                <p className="mt-1">いいね数</p>
                            </div>
                        </div>
                        <div className="lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
                            <a className="block relative h-48 rounded overflow-hidden">
                                <img alt="ecommerce" className="object-cover object-center w-full h-full block" src="https://dummyimage.com/210x297"></img>
                            </a>
                            <div className="mt-4">
                                <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">作成日</h3>
                                <h2 className="text-gray-900 title-font text-lg font-medium">タイトル</h2>
                                <p className="mt-1">いいね数</p>
                            </div>
                        </div>
                        <div className="lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
                            <a className="block relative h-48 rounded overflow-hidden">
                                <img alt="ecommerce" className="object-cover object-center w-full h-full block" src="https://dummyimage.com/210x297"></img>
                            </a>
                            <div className="mt-4">
                                <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">作成日</h3>
                                <h2 className="text-gray-900 title-font text-lg font-medium">タイトル</h2>
                                <p className="mt-1">いいね数</p>
                            </div>
                        </div>
                        <div className="lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
                            <a className="block relative h-48 rounded overflow-hidden">
                                <img alt="ecommerce" className="object-cover object-center w-full h-full block" src="https://dummyimage.com/210x297"></img>
                            </a>
                            <div className="mt-4">
                                <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">作成日</h3>
                                <h2 className="text-gray-900 title-font text-lg font-medium">タイトル</h2>
                                <p className="mt-1">いいね数</p>
                            </div>
                        </div>
                        <div className="lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
                            <a className="block relative h-48 rounded overflow-hidden">
                                <img alt="ecommerce" className="object-cover object-center w-full h-full block" src="https://dummyimage.com/210x297"></img>
                            </a>
                            <div className="mt-4">
                                <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">作成日</h3>
                                <h2 className="text-gray-900 title-font text-lg font-medium">タイトル</h2>
                                <p className="mt-1">いいね数</p>
                            </div>
                        </div>
                        <div className="lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
                            <a className="block relative h-48 rounded overflow-hidden">
                                <img alt="ecommerce" className="object-cover object-center w-full h-full block" src="https://dummyimage.com/210x297"></img>
                            </a>
                            <div className="mt-4">
                                <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">作成日</h3>
                                <h2 className="text-gray-900 title-font text-lg font-medium">タイトル</h2>
                                <p className="mt-1">いいね数</p>
                            </div>
                        </div>
                        <div className="lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
                            <a className="block relative h-48 rounded overflow-hidden">
                                <img alt="ecommerce" className="object-cover object-center w-full h-full block" src="https://dummyimage.com/210x297"></img>
                            </a>
                            <div className="mt-4">
                                <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">作成日</h3>
                                <h2 className="text-gray-900 title-font text-lg font-medium">タイトル</h2>
                                <p className="mt-1">いいね数</p>
                            </div>
                        </div>
                        <Link href= "recommendedarticles">
                            <button className="inline-flex items-center bg-gray-100 border-0 px-6 focus:outline-none hover:bg-gray-200 rounded-full mt-20 w-14 h-14">＞</button>
                        </Link>
                    </div>
                </div>
            </section>

            <section className="text-gray-600 body-font">
                <h2 className="sm:text-2xl sm:text-1xl font-medium title-font text-gray-900 p-8">作成中記事一覧</h2>
                <div className="container px-5 py-4 mx-auto">
                    <div className="flex flex-wrap -m-4">
                        <div className="lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
                            <a className="block relative h-48 rounded overflow-hidden">
                                <img alt="ecommerce" className="object-cover object-center w-full h-full block" src="https://dummyimage.com/210x297"></img>
                            </a>
                            <div className="mt-4">
                                <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">作成日</h3>
                                <h2 className="text-gray-900 title-font text-lg font-medium">タイトル</h2>
                            </div>
                        </div>
                        <div className="lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
                            <a className="block relative h-48 rounded overflow-hidden">
                                <img alt="ecommerce" className="object-cover object-center w-full h-full block" src="https://dummyimage.com/210x297"></img>
                            </a>
                            <div className="mt-4">
                                <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">作成日</h3>
                                <h2 className="text-gray-900 title-font text-lg font-medium">タイトル</h2>
                            </div>
                        </div>
                        <div className="lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
                            <a className="block relative h-48 rounded overflow-hidden">
                                <img alt="ecommerce" className="object-cover object-center w-full h-full block" src="https://dummyimage.com/210x297"></img>
                            </a>
                            <div className="mt-4">
                                <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">作成日</h3>
                                <h2 className="text-gray-900 title-font text-lg font-medium">タイトル</h2>
                            </div>
                        </div>
                        <div className="lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
                            <a className="block relative h-48 rounded overflow-hidden">
                                <img alt="ecommerce" className="object-cover object-center w-full h-full block" src="https://dummyimage.com/210x297"></img>
                            </a>
                            <div className="mt-4">
                                <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">作成日</h3>
                                <h2 className="text-gray-900 title-font text-lg font-medium">タイトル</h2>
                            </div>
                        </div>
                        <div className="lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
                            <a className="block relative h-48 rounded overflow-hidden">
                                <img alt="ecommerce" className="object-cover object-center w-full h-full block" src="https://dummyimage.com/210x297"></img>
                            </a>
                            <div className="mt-4">
                                <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">作成日</h3>
                                <h2 className="text-gray-900 title-font text-lg font-medium">タイトル</h2>
                            </div>
                        </div>
                        <div className="lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
                            <a className="block relative h-48 rounded overflow-hidden">
                                <img alt="ecommerce" className="object-cover object-center w-full h-full block" src="https://dummyimage.com/210x297"></img>
                            </a>
                            <div className="mt-4">
                                <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">作成日</h3>
                                <h2 className="text-gray-900 title-font text-lg font-medium">タイトル</h2>
                            </div>
                        </div>
                        <div className="lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
                            <a className="block relative h-48 rounded overflow-hidden">
                                <img alt="ecommerce" className="object-cover object-center w-full h-full block" src="https://dummyimage.com/210x297"></img>
                            </a>
                            <div className="mt-4">
                                <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">作成日</h3>
                                <h2 className="text-gray-900 title-font text-lg font-medium">タイトル</h2>
                            </div>
                        </div>
                        <button className="inline-flex items-center bg-gray-100 border-0 px-6 focus:outline-none hover:bg-gray-200 rounded-full mt-20 w-14 h-14">＞</button>
                    </div>
                </div>
            </section>

            <section className="text-gray-600 body-font">
                <h2 className="sm:text-2xl sm:text-1xl font-medium title-font text-gray-900 p-8">所属コミュニティ一覧</h2>
                <div className="flex flex-wrap sm:-m-4 -mx-4 -mb-10 -mt-4 md:space-y-0 px-16">
                    <div className="p-8 md:w-1/7 flex flex-col text-center items-center">
                        <div className="w-20 h-20 inline-flex items-center justify-center rounded-full bg-indigo-100 text-indigo-500 mb-5 flex-shrink-0">
                            <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-10 h-10" viewBox="0 0 24 24">
                                <path d="M20 21v-2a4 4 0 00-4-4H8a4 4 0 00-4 4v2"></path>
                                <circle cx="12" cy="7" r="4"></circle>
                            </svg>
                        </div>
                        <div className="flex-grow">
                            <h2 className="text-gray-900 text-lg title-font font-medium mb-3">タイトル</h2>
                                <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-4 h-4 ml-2" viewBox="0 0 24 24"></svg>
                        </div>
                    </div>
                    <div className="p-8 md:w-1/7 flex flex-col text-center items-center">
                        <div className="w-20 h-20 inline-flex items-center justify-center rounded-full bg-indigo-100 text-indigo-500 mb-5 flex-shrink-0">
                            <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-10 h-10" viewBox="0 0 24 24">
                                <path d="M20 21v-2a4 4 0 00-4-4H8a4 4 0 00-4 4v2"></path>
                                <circle cx="12" cy="7" r="4"></circle>
                            </svg>
                        </div>
                        <div className="flex-grow">
                            <h2 className="text-gray-900 text-lg title-font font-medium mb-3">タイトル</h2>
                                <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-4 h-4 ml-2" viewBox="0 0 24 24"></svg>
                        </div>
                    </div>
                    <div className="p-8 md:w-1/7 flex flex-col text-center items-center">
                        <div className="w-20 h-20 inline-flex items-center justify-center rounded-full bg-indigo-100 text-indigo-500 mb-5 flex-shrink-0">
                            <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-10 h-10" viewBox="0 0 24 24">
                                <path d="M20 21v-2a4 4 0 00-4-4H8a4 4 0 00-4 4v2"></path>
                                <circle cx="12" cy="7" r="4"></circle>
                            </svg>
                        </div>
                        <div className="flex-grow">
                            <h2 className="text-gray-900 text-lg title-font font-medium mb-3">タイトル</h2>
                                <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-4 h-4 ml-2" viewBox="0 0 24 24"></svg>
                        </div>
                    </div>
                    <div className="p-8 md:w-1/7 flex flex-col text-center items-center">
                        <div className="w-20 h-20 inline-flex items-center justify-center rounded-full bg-indigo-100 text-indigo-500 mb-5 flex-shrink-0">
                            <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-10 h-10" viewBox="0 0 24 24">
                                <path d="M20 21v-2a4 4 0 00-4-4H8a4 4 0 00-4 4v2"></path>
                                <circle cx="12" cy="7" r="4"></circle>
                            </svg>
                        </div>
                        <div className="flex-grow">
                            <h2 className="text-gray-900 text-lg title-font font-medium mb-3">タイトル</h2>
                                <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-4 h-4 ml-2" viewBox="0 0 24 24"></svg>
                        </div>
                    </div>
                    <div className="p-8 md:w-1/7 flex flex-col text-center items-center">
                        <div className="w-20 h-20 inline-flex items-center justify-center rounded-full bg-indigo-100 text-indigo-500 mb-5 flex-shrink-0">
                            <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-10 h-10" viewBox="0 0 24 24">
                                <path d="M20 21v-2a4 4 0 00-4-4H8a4 4 0 00-4 4v2"></path>
                                <circle cx="12" cy="7" r="4"></circle>
                            </svg>
                        </div>
                        <div className="flex-grow">
                            <h2 className="text-gray-900 text-lg title-font font-medium mb-3">タイトル</h2>
                                <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-4 h-4 ml-2" viewBox="0 0 24 24"></svg>
                        </div>
                    </div>
                    <div className="p-8 md:w-1/7 flex flex-col text-center items-center">
                        <div className="w-20 h-20 inline-flex items-center justify-center rounded-full bg-indigo-100 text-indigo-500 mb-5 flex-shrink-0">
                            <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-10 h-10" viewBox="0 0 24 24">
                                <path d="M20 21v-2a4 4 0 00-4-4H8a4 4 0 00-4 4v2"></path>
                                <circle cx="12" cy="7" r="4"></circle>
                            </svg>
                        </div>
                        <div className="flex-grow">
                            <h2 className="text-gray-900 text-lg title-font font-medium mb-3">タイトル</h2>
                                <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-4 h-4 ml-2" viewBox="0 0 24 24"></svg>
                        </div>
                    </div>
                    <div className="p-8 md:w-1/7 flex flex-col text-center items-center">
                        <div className="w-20 h-20 inline-flex items-center justify-center rounded-full bg-indigo-100 text-indigo-500 mb-5 flex-shrink-0">
                            <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-10 h-10" viewBox="0 0 24 24">
                                <path d="M20 21v-2a4 4 0 00-4-4H8a4 4 0 00-4 4v2"></path>
                                <circle cx="12" cy="7" r="4"></circle>
                            </svg>
                        </div>
                        <div className="flex-grow">
                            <h2 className="text-gray-900 text-lg title-font font-medium mb-3">タイトル</h2>
                                <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-4 h-4 ml-2" viewBox="0 0 24 24"></svg>
                        </div>
                    </div>
                    <button className="inline-flex items-center bg-gray-100 border-0 px-6 focus:outline-none hover:bg-gray-200 rounded-full mt-12 w-14 h-14">＞</button>
                </div>
            </section>
        </>
    )
}