"use client"
import React from 'react'
import { useRouter } from "next/navigation"
import { FormEvent, useState } from "react"

export default function SignupPage() {

    const router = useRouter()
    const [email, setEmail] = useState('')
    const [user, setUser] = useState('')
    const [school, setSchool] = useState('')
    const [password, setPassword] = useState('')
    async function onSubmit(event: FormEvent<HTMLFormElement>) {
      event.preventDefault()
      const sendData = {
        email: email,
        user: user,
        school: school,
        password: password
      }
      const response = await fetch('http://localhost:3000/api/v1/auth/sign_in', {
        method: 'POST',
        body: JSON.stringify(sendData),
        headers: {
          'Content-Type': 'application/json'
        }
      })
      const data = await response.json()
      const redirectPath = '/home'
      response.ok ? router.push(redirectPath) : alert(data.errors)
      setPassword('')
      console.log(data)
    }

  return (

  <>
    <section className="text-gray-600 body-font">
        <div className="container px-5 py-16 mx-auto flex flex-wrap items-center justify-center">
            <div className="lg:w-2/6 md:w-1/2 bg-gray-100 rounded-lg p-8 flex flex-col w-full mt-10 md:mt-0">
                <h2 className="text-gray-900 text-lg font-medium title-font mb-5">サインアップ</h2>
                <div className="relative mb-4">
                    <span className="after:content-['*'] after:ml-0.5 after:text-red-500 block text-sm font-medium text-slate-700">メールアドレス</span>
                    <input type="email" name="email" className="mt-1 px-3 py-2 bg-white border shadow-sm border-slate-300 placeholder-slate-400 focus:outline-none focus:border-sky-500 focus:ring-sky-500 block w-full rounded-md sm:text-sm focus:ring-1" placeholder="ここにメールアドレスを入力してください" 
                       id="email"
                       value={email}
                       required
                       onChange={(event) => setEmail(event.target.value)}
                    />
                </div>
                <div className="relative mb-4">
                    <span className="after:content-['*'] after:ml-0.5 after:text-red-500 block text-sm font-medium text-slate-700">ユーザー名</span>
                    <input type="text" className="mt-1 px-3 py-2 bg-white border shadow-sm border-slate-300 placeholder-slate-400 focus:outline-none focus:border-sky-500 focus:ring-sky-500 block w-full rounded-md sm:text-sm focus:ring-1" placeholder="ここにユーザー名を入力してください" 
                        id="user"
                        value={user}
                        required
                        onChange={(event) => setUser(event.target.value)}
                    />
                </div>
                <div className="relative mb-4">
                    <span className="after:content-['*'] after:ml-0.5 after:text-red-500 block text-sm font-medium text-slate-700">学校名</span>
                    <input type="text" className="mt-1 px-3 py-2 bg-white border shadow-sm border-slate-300 placeholder-slate-400 focus:outline-none focus:border-sky-500 focus:ring-sky-500 block w-full rounded-md sm:text-sm focus:ring-1" placeholder="ここに学校名を入力してください" 
                        id="school"
                        value={school}
                        required
                        onChange={(event) => setSchool(event.target.value)}
                    />
                </div>
                <div className="relative mb-4">
                    <span className="after:content-['*'] after:ml-0.5 after:text-red-500 block text-sm font-medium text-slate-700">パスワード</span>
                    <input type="text" className="mt-1 px-3 py-2 bg-white border shadow-sm border-slate-300 placeholder-slate-400 focus:outline-none focus:border-sky-500 focus:ring-sky-500 block w-full rounded-md sm:text-sm focus:ring-1" placeholder="ここにパスワードを入力してください" 
                     id="password"
                     value={password}
                     required
                     onChange={(event) => setPassword(event.target.value)}
                    />
                </div>
                <div className="relative mb-4">
                    <span className="after:content-['*'] after:ml-0.5 after:text-red-500 block text-sm font-medium text-slate-700">パスワード（確認用）</span>
                    <input type="text" className="mt-1 px-3 py-2 bg-white border shadow-sm border-slate-300 placeholder-slate-400 focus:outline-none focus:border-sky-500 focus:ring-sky-500 block w-full rounded-md sm:text-sm focus:ring-1" placeholder="ここにパスワードを入力してください" 
                    id="password"
                        value={password}
                        required
                        onChange={(event) => setPassword(event.target.value)}
                    />
                </div>
                <button className="text-white bg-indigo-500 border-0 py-2 px-8 focus:outline-none hover:bg-indigo-600 rounded text-lg">サインアップ</button>
            </div>
        </div>
    </section>
  </>

  )
}
