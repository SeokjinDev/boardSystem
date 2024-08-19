import React, { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import styled from "styled-components";
import CommentList from "../list/comment-list";
import postsData from "../../test-data/postsData.json";

const Wrapper = styled.div`
    padding: 16px;
    width: 90%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
`;

const Container = styled.div`
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    gap: 16px;
`;

const PostContainer = styled.div`
    padding: 16px;
    border: 1px solid grey;
    border-radius: 8px;
    width: 100%;
`;

const TitleText = styled.h1`
    font-size: 24px;
    margin-bottom: 16px;
`;

const ContentText = styled.p`
    font-size: 18px;
    line-height: 1.6;
    white-space: pre-wrap;
`;

const CommentLabel = styled.p`
    font-size: 16px;
    font-weight: 500;
`;

const Button = styled.button`
    width: 20%;
    padding: 12px 16px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 8px;
    background-color: #007bff;
    color: white;
    cursor: pointer;
    transition: background-color 0.3s;

    &:hover {
        background-color: #0056b3;
    }
`;

const TextArea = styled.textarea`
    padding: 8px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
    width: 100%;
    height: 80px;
    resize: none;
    margin-top: 8px;
`;

const CommentContainer = styled.div`
    width: 100%;
`;

const PostHeader = styled.div`
    width: 100%;
    display: flex;
    flex-direction: row;
    justify-content: center;
`;

function PostDetailPage(props) {
    const navigate = useNavigate();
    const { postID } = useParams();
    const [comment, setComment] = useState("");
    const [comments, setComments] = useState([]);

    const post = postsData.posts.find((post) => {
        return post.id === parseInt(postID, 10);
    });

    if (!post) {
        return <Wrapper>포스트를 찾을 수 없습니다.</Wrapper>;
    }

    const handleCommentSubmit = () => {
        if (comment.trim() !== "") {
            console.log(comment)
            setComments([...comments, { text: comment }]);
            setComment("");
        }
    };

    return (
        <Wrapper>
            <Container>
                <PostHeader>
                    <Button
                        onClick={() => {
                            navigate("/");
                        }}
                    >
                        Back
                    </Button>
                    <Button
                        onClick={() => {
                            /* 수정 링크 만들 예정 */
                            navigate("/");
                        }}
                    >
                        Update
                    </Button>
                    <Button
                        onClick={() => {
                            /* 삭제 링크 만들 예정 */
                            navigate("/");
                        }}
                    >
                        Delete
                    </Button>
                </PostHeader>
                <PostContainer>
                    <TitleText>{post.title}</TitleText>
                    <ContentText>{post.content}</ContentText>
                </PostContainer>
                
                <CommentContainer>
                    <CommentLabel>Comments</CommentLabel>
                    <CommentList comments={[...post.comments, ...comments]} />

                    <TextArea
                        value={comment}
                        onChange={(event) => {
                            setComment(event.target.value);
                        }}
                        placeholder="댓글을 입력하세요"
                    />
                    <Button onClick={handleCommentSubmit}>댓글 추가</Button>
                </CommentContainer>
            </Container>
        </Wrapper>
    );
}

export default PostDetailPage;