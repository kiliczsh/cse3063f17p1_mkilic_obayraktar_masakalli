#!/usr/bin/env python

import re
import string
import operator
from os import path
from wordcloud import WordCloud

d = path.dirname(__file__)

# Read the whole text.
text = open(path.join(d, 'test.txt')).read()



# Generate text to count
frequency = {}
document_text = open('test.txt', 'r')
text_string = document_text.read().lower()
match_pattern = re.findall(r'\b[a-z]{3,15}\b', text_string)
# count
for word in match_pattern:
    count = frequency.get(word,0)
    frequency[word] = count + 1

# sort
value = [(frequency[key],key) for key in frequency]
value.sort() #smallest to biggest
value.reverse() # biggest to smallest
# print
kelimeSayisi=0

for a in value:
    if (kelimeSayisi <50):
        print((kelimeSayisi+1),a, sep=" : ")
        kelimeSayisi = kelimeSayisi+1

#print(*value[0:40],"\n")
print(type(frequency))


for k in frequency:
    print(k)
# Generate a word cloud image

# color function
def random_color_func(word=None, font_size=None, position=None, orientation=None, font_path=None, random_state=None):
    h = int(360.0 * float(random_state.randint(60, 250)) / 255.0)
    s = int(100.0 * float(random_state.randint(60, 250)) / 255.0)
    l = int(100.0 * float(random_state.randint(60, 250)) / 255.0)
    return "hsl({}, {}%, {}%)".format(h, s, l)

# Display the generated image:
# the matplotlib way:
import matplotlib.pyplot as plt
#plt.imshow(wordcloud, interpolation='bilinear')
#plt.axis("off")

# lower max_font_size
wordcloud = WordCloud(background_color = 'white',
                        width = 1200,
                        height = 1000,
                        color_func = random_color_func).generate(text)
plt.figure()
plt.imshow(wordcloud, interpolation="bilinear")
plt.axis("off")
plt.show()

# The pil way (if you don't have matplotlib)
# image = wordcloud.to_image()
# image.show()
