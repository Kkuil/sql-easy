import {LayoutHeader} from "./LayoutHeader.tsx"
import {LayoutContent} from "./LayoutContent.tsx"
import {LayoutSide} from "./LayoutSide.tsx"

export function Layout() {
	return (
		<>
			<div className="header">
				<LayoutHeader/>
			</div>
			<div className="content">
				<LayoutContent/>
			</div>
			<div className="side">
				<LayoutSide/>
			</div>
		</>
	)
}