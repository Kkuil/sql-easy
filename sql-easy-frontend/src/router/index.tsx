import {createBrowserRouter} from "react-router-dom"
import {Layout} from "@/layout/Layout.tsx"
import {NotFound} from "@/views/NotFound/NotFound.tsx"
import {LoginRegistry} from "@/views/LoginRegistry/LoginRegistry.tsx"

const router = createBrowserRouter([
	{
		path: "/",
		element: <Layout/>,
		errorElement: <NotFound/>,
		hasErrorBoundary: true,
	},
	{
		path: "/login",
		element: <LoginRegistry/>
	}
])

export default router