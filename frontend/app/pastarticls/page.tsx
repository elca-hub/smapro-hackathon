import React from 'react'

function page() {
  return (
    <>
        <label className="relative block px-52 mt-6">
            <span className="sr-only">Search</span>
            <span className="absolute inset-y-0 left-0 flex items-center pl-2">
                <svg className="h-5 w-5 fill-slate-300" viewBox="0 0 20 20"></svg>
            </span>
            <input className="placeholder:italic placeholder:text-slate-400 block bg-white w-full border border-slate-300 rounded-md py-2 pl-9 pr-3 shadow-sm focus:outline-none focus:border-sky-500 focus:ring-sky-500 focus:ring-1 sm:text-sm" placeholder="検索" type="text" name="search"/>
        </label>

        <section className="text-gray-600 body-font">
            <h2 className="sm:text-2xl sm:text-1xl font-medium title-font text-gray-900 p-8">過去見た記事一覧</h2>
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
                </div>
            </div>
        </section>

    </>
  )
}

export default page