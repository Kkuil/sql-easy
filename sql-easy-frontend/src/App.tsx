import {RouterProvider} from "react-router"
import router from "@/router/index.tsx"
import {useEffect} from "react"
import {auth} from "@/api/userCommon.ts"
import {message} from "antd"
import {store} from "@/store"

function App() {
	useEffect(() => {
		getUserInfo()
		return () => {
		}
	}, [])

	// 获取用户信息
	const getUserInfo = async () => {
		try {
			const result = await auth()
			if (result.data) {
				store.dispatch({
					type: "user/setInfo",
					payload: result.data
				})
			}
		} catch (e) {
			message.error("token已失效或无效")
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
