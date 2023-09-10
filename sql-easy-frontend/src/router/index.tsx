import {createBrowserRouter} from "react-router-dom"
import {Layout} from "@/layout/Layout.tsx"
import {NotFound} from "@/views/NotFound/NotFound.tsx"
import {LoginRegistry} from "@/views/LoginRegistry/LoginRegistry.tsx"
import {UserManage} from "@/views/Manage/UserManage/UserManage.tsx"
import {SqlEasy} from "@/views/SqlEasy/SqlEasy.tsx"
import {Manage} from "@/views/Manage/Manage.tsx"

export default createBrowserRouter([
	{
		path: "/",
		element: <Layout/>,
		errorElement: <NotFound/>,
		children: [
			{
				path: "/",
				element: <SqlEasy/>
			},
			{
				path: "/sql-easy",
				element: <SqlEasy/>
			},
			{
				path: "/manage",
				element: <Manage/>,
				children: [
					{
						path: "/manage/user-manage",
						element: <UserManage/>
					}
				]
			}
		]
	},
	{
		path: "/login",
		element: <LoginRegistry/>
	}
])

