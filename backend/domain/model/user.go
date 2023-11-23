package model

type User struct {
	ID          int64  `json:"id"`
	MailAddress string `json:"mail_address"`
	Password    string `json:"password"`
	UserName    string `json:"user_name"`
	SchoolName  string `json:"school_name"`
}
