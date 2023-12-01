"use client";

import AuthRequest from "@/request/AuthRequest";
import AuthResponse from "@/request/model/AuthResponse";
import AuthToken from "@/request/model/AuthToken";
import { useRouter } from "next/navigation"
import { FormEvent, useEffect, useState } from "react"

const authRequest = new AuthRequest(new AuthToken())

export default function CreateArticlePage () {
  const router = useRouter()
  const [name, setName] = useState('')
  const [description, setDescription] = useState('')

  async function onSubmit (e: FormEvent<HTMLFormElement>) {
    e.preventDefault()

    const sendData = {
      name,
      description
    }

    const res: AuthResponse = await authRequest.request('community/', 'POST', sendData)

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

  return (
    <>
      <h2 className="sm:text-3xl text-2xl font-medium title-font text-gray-900 p-8">
        コミュニティの作成
      </h2>

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
              作成する
            </button>
          </div>
        </form>
      </div>
    </>
  )
}