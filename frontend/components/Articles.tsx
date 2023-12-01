export default function Articles() {
  return (
    <div className="lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
      <a className="block relative h-48 rounded overflow-hidden">
        <img
          alt="ecommerce"
          className="object-cover object-center w-full h-full block"
          src="https://dummyimage.com/210x297"
        ></img>
      </a>
      <div className="mt-4">
        <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">
          最終更新日時
        </h3>
        <h2 className="text-gray-900 title-font text-lg font-medium">
          タイトル
        </h2>
        <p className="mt-1">いいね数</p>
      </div>
    </div>
  );
}
