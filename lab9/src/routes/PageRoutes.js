import { Route, Routes } from "react-router-dom";
import Login from "../components/Login";
import NotFound from "../components/NotFound";
import RequireAuth from "../components/RequireAuth";
import Dashboard from "../components/Dashboard";
import AddPost from "../components/AddPost";
import PostDetail from "../components/PostDetail";


export default function PageRoutes() {
    return (
        <Routes>
            <Route path="/login" element={<Login />} />
            <Route element={<RequireAuth />} >
                <Route path="/" element={<Dashboard />} />
                <Route path="/post" element={<AddPost />} />
                <Route path="/posts/:id" element={<PostDetail />} />
            </Route>
            <Route path="*" element={<NotFound />} />
        </Routes>
    );
}