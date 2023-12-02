"use client";

import AuthRequest from "@/request/AuthRequest";
import AuthToken from "@/request/model/AuthToken";
import Link from "next/link";
import { useRouter } from "next/navigation";
import { FormEvent, useEffect, useState } from "react";
import { BsChevronDoubleRight } from "react-icons/bs";

type Community = {
  id: string;
  name: string;
  desciption: string;
}

const fetchCommunity = async (communityId: string): Promise<Community> => {
  const authRequest: AuthRequest = new AuthRequest(new AuthToken());
  const res = await authRequest.request(`community/${communityId}`, 'GET')  

  const data = res.json
  if (data.status === 'SUCCESS' && res.status === 200 && data.data.isOwner) {
    const communityData = data.data

    return {
      id: communityData.communityId,
      name: communityData.name,
      desciption: communityData.description,
    }
  } else {
    throw new Error('failed to fetch community')
  }
}

export default function UpdateCommunityPage({ params }: { params: { communityId: string } }) {
  const [community, setCommunity] = useState<Community>()
  const [name, setName] = useState('')
  const [description, setDescription] = useState('')
  const router = useRouter()
  const authRequest = new AuthRequest(new AuthToken())

  useEffect(() => {
    (async () => {
      try {
        const data = await fetchCommunity(params.communityId)

        setCommunity(data)
        setName(data.name)
        setDescription(data.desciption)
      } catch (e) {
        router.push('/community')
      }
    })()
  }, [params.communityId, router])

  async function deleteCommunity () {
    const res = await authRequest.request(`community/${params.communityId}`, 'DELETE')

    const data = res.json
    const status = res.status

    if (data.status === 'SUCCESS' && status === 200) {
      router.push('/community')
      return
    } else {
      if (status === 200 && data.status === 'ERROR') {
        alert(data.message)
        return
      } else {
        alert('エラーが発生しました')
        return
      }
    }
  }

  async function onSubmit (e: FormEvent<HTMLFormElement>) {
    e.preventDefault()

    const sendData = {
      name,
      description
    }

    const res = await authRequest.request(`community/${params.communityId}`, 'PUT', sendData)

    const data = res.json
    const status = res.status

    if (data.status === 'SUCCESS' && status === 200) {
      router.push(`/community/${params.communityId}`)
      return
    } else {
      if (status === 200 && data.status === 'ERROR') {
        alert(data.message)
        return
      } else {
        alert('エラーが発生しました')
        return
      }
    }
  }

  return (
    <>
      <div className="flex justify-between">
        <h1 className="text-2xl font-bold text-slate-900">コミュニティー編集</h1>
        <div className="flex items-center">
          <Link href={`/community/${params.communityId}`} className="text-sky-500 hover:text-sky-600">
            <BsChevronDoubleRight className="w-6 h-6" />
            コミュニティへ
          </Link>
        </div>
      </div>
      <div className="mt-6">
        <div className="bg-white shadow overflow-hidden sm:rounded-lg">
          <div className="px-6">
            <form onSubmit={onSubmit}>
              <div className="mb-3">
                <label className="block text-gray-700 text-sm font-bold mb-2">
                  コミュニティ名
                </label>
                <input
                  className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight"
                  id="name"
                  type="text"
                  placeholder="コミュニティ名"
                  value={name}
                  onChange={(e) => setName(e.target.value)}
                  required
                ></input>
              </div>

              <div className="mb-3">
                <label className="block text-gray-700 text-sm font-bold mb-2">
                  概要
                </label>
                <textarea
                  className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight"
                  id="description"
                  placeholder="概要"
                  value={description}
                  onChange={(e) => setDescription(e.target.value)}
                  required
                ></textarea>
              </div>

              <div className="text-center my-6">
                <button
                  className="bg-green-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
                  type="submit"
                >
                  変更する
                </button>
              </div>
            </form>

            <div className="text-center my-6">
              <button
                className="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded"
                onClick={deleteCommunity}
              >
                削除する
              </button>
            </div>
          </div>
        </div>
      </div>
    </>
  )
}
