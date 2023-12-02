type Prop = {
  name: string;
  id: string;
};

export default function JoinedUser({ name, id }: Prop) {
  return (
    <li>
      <a href={`/user/${id}`}>
        <p>{name}</p>
      </a>
    </li>
  )
}
