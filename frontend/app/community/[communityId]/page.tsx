import AuthRequest from "@/request/AuthRequest";
import AuthToken from "@/request/model/AuthToken";
import { useRouter } from "next/navigation";
import { useEffect, useState } from "react";

const authRequest: AuthRequest = new AuthRequest(new AuthToken());

type User = {
  id: string;
  name: string;
}

type Community = {
  id: string;
  name: string;
  desciption: string;
  member: User[];
  isOwner: boolean;
}

const fetchCommunity = async (communityId: string): Promise<Community> => {
  const res = await authRequest.request(`community/${communityId}`, 'GET')
  const data = res.json
  if (data.status === 'SUCCESS' && res.status === 200) {
    const communityData = data.data

    return {
      id: communityData.communityId,
      name: communityData.name,
      desciption: communityData.description,
      isOwner: communityData.isOwner,
      member: communityData.member.map((member: any) => {
        return {
          id: member.userId,
          name: member.name
        }
      })
    }
  } else {
    throw new Error('failed to fetch community')
  }
}

export default function ShowCommunityPage({ params }: { params: { communityId: string } }) {
  const [community, setCommunity] = useState<Community>( {} as Community)
  const router = useRouter()

  useEffect(() => {
    (async () => {
      try {
        const data = await fetchCommunity(params.communityId)

        setCommunity(data)
      } catch (e) {
        router.push('/community')
      }
    })()
  }, [params.communityId, router])

  return (
    <>
      <h2 className="sm:text-3xl text-2xl font-medium title-font text-gray-900 p-8">
        {community.name}
      </h2>

      <section className="text-gray-600 body-font">
        <h2 className="sm:text-2xl sm:text-1xl font-medium title-font text-gray-900 p-8">
          所属ユーザ一覧
        </h2>
      </section>
    </>
  )
}
