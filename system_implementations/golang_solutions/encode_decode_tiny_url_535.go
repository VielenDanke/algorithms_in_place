package golang_solutions

import (
	"fmt"
	"math/rand"
	"net/url"
	"time"
)

const letterBytes = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+-"

var src = rand.NewSource(time.Now().UnixNano())

type Codec struct {
	urlMap map[string]string
}

func Constructor() Codec {
	return Codec{urlMap: make(map[string]string)}
}

func (this *Codec) Encode(longUrl string) string {
	parsedURL, err := url.Parse(longUrl)
	if err != nil {
		return ""
	}
	randomShortURL := randomStringGenerator(7)
	shortUrl := fmt.Sprintf("%s://%s/%s", parsedURL.Scheme, parsedURL.Host, randomShortURL)
	this.urlMap[shortUrl] = longUrl
	return shortUrl
}

func (this *Codec) Decode(shortUrl string) string {
	longUrl, ok := this.urlMap[shortUrl]
	if !ok {
		return ""
	}
	return longUrl
}

func randomStringGenerator(n int) string {
	b := make([]byte, n)
	for i := range b {
		b[i] = letterBytes[src.Int63()%int64(len(letterBytes))]
	}
	return string(b)
}

/**
 * Your Codec object will be instantiated and called as such:
 * obj := Constructor();
 * url := obj.encode(longUrl);
 * ans := obj.decode(url);
 */
