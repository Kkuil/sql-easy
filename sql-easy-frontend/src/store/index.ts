import {configureStore} from "@reduxjs/toolkit"
import CountReducer from "./modules/countSlice.ts"
import UserReducer from "./modules/userSlice.ts"
import CoreReducer from "@/store/modules/coreSlice.ts"

export const store = configureStore({
	reducer: {
		counter: CountReducer,
		user: UserReducer,
		core: CoreReducer
	},
})

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch