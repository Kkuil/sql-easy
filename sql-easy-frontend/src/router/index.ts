import {createBrowserRouter} from "react-router-dom"
import {Layout} from "@/layout/Layout.tsx"
import {NotFound} from "@/views/NotFound/NotFound.tsx"

const router = createBrowserRouter([
	{
		path: "/",
		element: Layout(),
		errorElement: NotFound(),
		hasErrorBoundary: true,
	},
], {
	basename: "/base-name"
})

export default router