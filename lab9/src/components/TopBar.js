import { Link } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import { useNavigate } from 'react-router';
import { authActions } from '../app/Store';
import Cookies from 'js-cookie';

function TopBar() {
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const auth = useSelector(state => state.auth);
    const handleLogout = () => {
        dispatch(authActions.logout());
        Cookies.remove('user');
        navigate('/login');
    }

    return (
        <div className="top-bar">
            {
                auth.isAuthenticated ?
                    <div>
                        <div className="left-panel">
                            <Link className='menu-item' to="/">Post</Link>
                            <Link className='menu-item' to="/post">New Post</Link>
                            <Link className='menu-item' onClick={handleLogout}>Logout</Link>
                        </div>
                    </div>
                    : <div className="right-panel"><p>Sign In to continue</p></div>
            }
        </div>
    );
}

export default TopBar;