import React from "react";
import PostItem from "./PostItem";

export default function PostsComponent({ posts, onItemClicked }) {
    return (
        <div className="grid-container">
            {posts.map((post, index) => (
                <div  key={`${post.id}_${index}`} onClick={() => onItemClicked(post)}>
                    <PostItem post={post} />
                </div>

            ))}
        </div>
    );

}