import {createSlice} from "@reduxjs/toolkit"
import {TUserInfo} from "@/types/user"

interface UserState {
	info: TUserInfo
}

const initialState: UserState = {
	info: {
		id: "",
		username: ""
	}
}

export const userSlice = createSlice({
	name: "user",
	initialState,
	reducers: {
		setInfo: (state, payload) => {
			state.info = payload.payload
		},
	},
})

export const {setInfo} = userSlice.actions

export default userSlice.reducer