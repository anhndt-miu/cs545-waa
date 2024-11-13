import React from 'react';
import { Link } from 'react-router-dom';
export default function Post({ post }) {
    return (
        <div className="post-item-card">
            <Link to={`/posts/${post.id}`} className="post-item-card-link" >
                <div  >
                    <p className="post-id">{post?.id ?? ''}</p>
                    <h2 className="post-title">{post?.title ?? ''}</h2>
                    <p className="post-author">{post?.author ?? ''}</p>
                </div>
            </Link>
        </div>
    );
}