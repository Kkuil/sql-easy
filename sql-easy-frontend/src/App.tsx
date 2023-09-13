import {RouterProvider} from "react-router"
import router from "@/router/index.tsx"
import {useEffect} from "react"
import {auth} from "@/api/userCommon.ts"
import {message} from "antd"
import {store} from "@/store"

function App() {
	useEffect(() => {
		getUserInfo().then(() => {
		})
		return () => {
		}
	}, [])

	// 获取用户信息
	const getUserInfo = async () => {
		try {
			const result = await auth()
			if (!result.data) {
				return message.error("token已失效或无效")
			}
			store.dispatch({
				type: "user/setInfo",
				payload: result.data
			})
		} catch (e) {
			console.log(e)
		}
	}
	return (
		<>
			<RouterProvider
				router={router}
			/>
		</>
	)
}

export default App
