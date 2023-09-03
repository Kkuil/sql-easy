import {configureStore} from "@reduxjs/toolkit"
import CountReducer from "./modules/countSlice.ts"

export const store = configureStore({
    reducer: {
        counter: CountReducer
    },
})

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch