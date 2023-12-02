type Props = {
  title: string
}

export default function Articles({title}: Props) {
  return (
    <div className="lg:w-1/7 md:w-1/7 p-4 max-w-full h-auto">
      <div className="mt-4 flex-grow">
        <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">
          最終更新日時
        </h3>
        <h2 className="text-gray-900 title-font text-lg font-medium">
          {title}
        </h2>
        <p className="mt-1">リアクション数</p>
      </div>
    </div>
  );
}
