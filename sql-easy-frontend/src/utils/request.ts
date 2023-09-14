import axios from "axios"
import {TOKEN_KEY_IN_HEADER, TOKEN_KEY_IN_HEADER_PREFIX, TOKEN_KEY_IN_LOCAL_STORAGE} from "@/constant/user.ts"

const BASE_URL: string = "http://127.0.0.1"
const BASE_PORT: number = 3017
const BASE_TIMEOUT: number = 10000
const BASE_PREFIX: string = "/sql-easy"

console.log(BASE_URL, BASE_PORT, BASE_TIMEOUT, BASE_PREFIX)

const request = axios.create({
	baseURL: BASE_URL + ":" + BASE_PORT + BASE_PREFIX,
	timeout: BASE_TIMEOUT
})

// 请求拦截器
request.interceptors.request.use(
	(config) => {
		const token = localStorage.getItem(TOKEN_KEY_IN_LOCAL_STORAGE)
		if (!token) return config
		const token_header = TOKEN_KEY_IN_HEADER_PREFIX + token
		config.headers[TOKEN_KEY_IN_HEADER] = token_header
		return config
	},
	(error) => {
		console.log(error)
	}
)

// 响应拦截器
request.interceptors.response.use(
	(response) => {
		return response.data
	},
	(error) => {
		console.log(error)
	}
)

export default request
