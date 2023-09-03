import {store} from "@/store/index.ts"
import {Button} from "antd"
import {useState} from "react"

export function LayoutContent() {
	const [count, setCount] = useState(0)
	const incr = () => {
		store.dispatch({
			type: "counter/increment"
		})
		setCount(count + 1)
	}
	const decr = () => {
		store.dispatch({
			type: "counter/decrement"
		})
		setCount(count + 1)
	}
	return (
		<div className="layout-content">
			<span>{store.getState().counter.value}</span>
			<Button type="primary" onClick={incr}>+</Button>
			<Button type="primary" onClick={decr}>-</Button>
		</div>
	)
}