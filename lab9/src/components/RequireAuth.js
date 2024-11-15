import { useSelector } from "react-redux";
import { useLocation, Navigate, Outlet } from "react-router-dom";

export default function RequireAuth({ }) {
    const isAuthenticated = useSelector(state => state.auth.isAuthenticated);
    const location = useLocation();
    return (
        isAuthenticated ?
            <Outlet />
            : <Navigate to="/login" state={{ from: location }} replace />
    );
}