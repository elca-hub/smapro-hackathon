import AuthRequestError from "./AuthRequestError";

export default class AuthToken {
  private readonly tokenStorageKey = 'token';

  private token;

  constructor() {
    const storageTokenValue = localStorage.getItem(this.tokenStorageKey);

    this.token = storageTokenValue;
  }

  public getToken(): string {
    return this.token;
  }
}
