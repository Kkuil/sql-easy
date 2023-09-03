import {createBrowserRouter} from "react-router-dom"
import {Layout} from "@/layout/Layout.tsx"
import {NotFound} from "@/views/NotFound/NotFound.tsx"
import {Login} from "@/views/Login/Login.tsx"

const router = createBrowserRouter([
	{
		path: "/",
		element: <Layout/>,
		errorElement: <NotFound/>,
		hasErrorBoundary: true,
	},
	{
		path: "/login",
		element: <Login/>
	}
])

export default router