"use client";

import { useRouter } from "next/navigation"
import { FormEvent, useState } from "react"

export default function CreateArticlePage () {
  const router = useRouter()
  const [title, setTitle] = useState('')
  const [content, setContent] = useState('')

  async function onSubmit (e: FormEvent<HTMLFormElement>) {
    e.preventDefault()

    const sendData = {
      title,
      content
    }

    const res = await fetch('http://localhost:5050/article/', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(sendData)
    })

    const data = await res.json()
  }

  return (
    <>
      <h2 className="sm:text-3xl text-2xl font-medium title-font text-gray-900 p-8">
        記事の作成
      </h2>

      <div className="px-6">
        <form onSubmit={onSubmit}>
          <div className="mb-3">
            <label className="block text-gray-700 text-sm font-bold mb-2">
              タイトル
            </label>
            <input
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight"
              id="title"
              type="text"
              placeholder="タイトル"
              value={title}
              onChange={(e) => setTitle(e.target.value)}
              required
            ></input>
          </div>

          <div className="mb-3">
            <label className="block text-gray-700 text-sm font-bold mb-2">
              内容
            </label>
            <textarea
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight"
              id="content"
              placeholder="内容"
              value={content}
              onChange={(e) => setContent(e.target.value)}
              required
            ></textarea>
          </div>
        </form>
      </div>
    </>
  )
}