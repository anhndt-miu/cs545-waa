import React from 'react';

export default function Post({ post, onItemClicked }) {

    return (
        <div className="post-item-card" onClick={()=> onItemClicked(post.id)}>
            <div className="post-item-card-link" >
                <p className="post-id">{post?.id ?? ''}</p>
                <h2 className="post-title">{post?.title ?? ''}</h2>
                <p className="post-author">{post?.author ?? ''}</p>
            </div>
        </div>
    );
}