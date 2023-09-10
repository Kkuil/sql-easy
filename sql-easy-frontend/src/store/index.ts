import {configureStore} from "@reduxjs/toolkit"
import CountReducer from "./modules/countSlice.ts"
import UserReducer from "./modules/userSlice.ts"

export const store = configureStore({
	reducer: {
		counter: CountReducer,
		user: UserReducer
	},
})

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch