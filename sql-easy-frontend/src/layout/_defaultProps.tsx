import {CrownFilled, SmileFilled,} from "@ant-design/icons"

export default {
	route: {
		path: "/",
		routes: [
			{
				path: "/sql-easy",
				name: "SQL生成",
				icon: <SmileFilled/>,
				component: "@/views/SqlEasy/SqlEasy.tsx",
			},
			{
				path: "/manage",
				name: "管理页面",
				icon: <CrownFilled/>,
				access: "canAdmin",
				routes: [
					{
						path: "/manage/user-manage",
						name: "用户管理",
						icon: "https://gw.alipayobjects.com/zos/antfincdn/upvrAjAPQX/Logo_Tech%252520UI.svg",
						component: "@/views/Manage/UserManage/UserManage.tsx",
					},
				],
			},
		],
	},
	location: {
		pathname: "/",
	},
}