type Props = {
  title: string;
  number: number;
};

export default function Communities({title, number}: Props) {
  return (
    <div className="p-8 md:w-1/7 flex flex-col text-center items-center">
      <div className="flex-grow">
        <h2 className="text-gray-900 text-lg title-font font-medium mb-3">
          {title}
        </h2>
        <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">
          {number}
        </h3>
      </div>
    </div>
  );
}
