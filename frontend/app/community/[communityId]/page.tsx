"use client";

import AuthRequest from "@/request/AuthRequest";
import AuthToken from "@/request/model/AuthToken";
import { useRouter } from "next/navigation";
import { useEffect, useState } from "react";
import JoinedUser from "./_components/JoinedUser";

type User = {
  id: string;
  name: string;
}

type Community = {
  id: string;
  name: string;
  desciption: string;
  members: User[];
  isOwner: boolean;
  entryCode: string;
}

const fetchCommunity = async (communityId: string): Promise<Community> => {
  const authRequest: AuthRequest = new AuthRequest(new AuthToken());

  const res = await authRequest.request(`community/${communityId}`, 'GET')
  const data = res.json
  if (data.status === 'SUCCESS' && res.status === 200) {
    const communityData = data.data

    return {
      id: communityData.communityId,
      name: communityData.name,
      desciption: communityData.description,
      isOwner: communityData.isOwner,
      members: communityData.members.map((member: any) => {
        return {
          id: member.userId,
          name: member.name
        }
      }),
      entryCode: communityData.entryCode
    }
  } else {
    throw new Error('failed to fetch community')
  }
}

export default function ShowCommunityPage({ params }: { params: { communityId: string } }) {
  const [community, setCommunity] = useState<Community>()
  const router = useRouter()

  useEffect(() => {
    (async () => {
      try {
        const data = await fetchCommunity(params.communityId)

        console.log(data)

        setCommunity(data)
      } catch (e) {
        router.push('/community')
      }
    })()
  }, [params.communityId, router])

  return (
    <>
      <h2 className="sm:text-3xl text-2xl font-medium title-font text-gray-900 p-8">
        {community?.name}
      </h2>
      
      <section className="text-gray-600 body-font">
        <p className="leading-relaxed p-3 ml-3">
          {community?.desciption}
        </p>
      </section>
      
      <section className="text-gray-600 body-font">
        <h2 className="sm:text-2xl sm:text-1xl font-medium title-font text-gray-900 p-3 text-center">
          参加コード
        </h2>
        <p className="leading-relaxed p-3 ml-3 text-center">
          {community?.entryCode}
        </p>
      </section>

      <section className="text-gray-600 body-font">
        <h2 className="sm:text-2xl sm:text-1xl font-medium title-font text-gray-900 p-3 text-center">
          所属ユーザ一覧
        </h2>

        <ul className="list-none text-center m-4">
          {
            community?.members.map(member => {
              return <JoinedUser id={member.id} name={member.name} key={member.id}></JoinedUser>
            })
          }
        </ul>
      </section>
    </>
  )
}
