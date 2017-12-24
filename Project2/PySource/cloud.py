#!/usr/bin/env python3
#20-12-2017 02:34:47 

import os
import sys
import re
import time
import PyPDF2
import string
import operator
import csv
import glob
import more_itertools as mit
from os import listdir
from os.path import isfile, join
from os import path
from wordcloud import WordCloud
import matplotlib.pyplot as plt
import matplotlib.image as mimage
from matplotlib.backends.backend_pdf import PdfPages
from subprocess import Popen, PIPE
import time

"""FUNCTIONS"""

# converting doc to pdf
"""
def convert(src, dst):
    d = {'src': src, 'dst': dst}
    commands = [
        '/usr/bin/docsplit pdf --output %(dst)s %(src)s' % d,
        'oowriter --headless -convert-to pdf:writer_pdf_Export %(dst)s %(src)s' % d,
    ]

    for i in range(len(commands)):
        command = commands[i]
        st = time.time()
        process = Popen(command, stdout=PIPE, stderr=PIPE, shell=True) # I am aware of consequences of using `shell=True` 
        out, err = process.communicate()
        errcode = process.returncode
        if errcode != 0:
            raise Exception(err)
        en = time.time() - st
        print ('Command %s: Completed in %s seconds' % (str(i+1), str(round(en, 2))))
"""

# get number of pages of a pdf
def getPageCount(pdf_file):
	pdfFileObj = open(pdf_file, 'rb')
	pdfReader = PyPDF2.PdfFileReader(pdfFileObj)
	pages = pdfReader.numPages
	return pages
	
# get text in pdf 
def extractData(pdf_file, numPages):
	for page in range(numPages):
		pdfFileObj = open(pdf_file, 'rb')
		pdfReader = PyPDF2.PdfFileReader(pdfFileObj)
		pageObj = pdfReader.getPage(page)
		data = pageObj.extractText()
		data.join(data)	
	return data

# get word count for text of a pdf
def getWordCount(data):
	data=data.split()
	return len(data)

# get distinct words for pdf
def getUniqueItems(iterable):
	result = []
	for item in iterable:
	    if item not in result:
	        result.append(item)
	return result

# color function
def random_color_func(word=None, font_size=None, position=None, orientation=None, font_path=None, random_state=None):
    h = int(360.0 * float(random_state.randint(60, 250)) / 255.0)
    s = int(100.0 * float(random_state.randint(60, 250)) / 255.0)
    l = int(100.0 * float(random_state.randint(60, 250)) / 255.0)
    return "hsl({}, {}%, {}%)".format(h, s, l)
    

"""END OF FUNCTIONS"""


"""MAIN"""
def main():
	docListVar  = glob.glob("input/*.doc")
	docxListVar = glob.glob("input/*.docx")
	
	for docFiles in docListVar:
		doc1=docFiles
		in_file = os.path.abspath(docFiles)
		doc2=docFiles.replace(".doc",".pdf")
		out_file = os.path.abspath(docFiles)
		#convert(doc1,doc2)
	for docxFiles in docxListVar:
		docx1=docxFiles
		in_file = os.path.abspath(docxFiles)
		docx2=docFiles.replace(".docx",".pdf")
		out_file = os.path.abspath(docxFiles)
		#convert(docx1,docx2)

	pdfListVar  = glob.glob("input/*.pdf")
	for pdfFile in pdfListVar:
		print("File: ",pdfFile)
		# check if the specified file exists or not
		try:
			if os.path.exists(pdfFile):
				print("File found!")
		except OSError as err:
			print(err.reason)
			exit(1)
		# get the word count in the pdf file
		totalWords = 0
		numPages = getPageCount(pdfFile)
		print("num of pages ",numPages)
		
		
		wordstring = extractData(pdfFile, numPages)
	
			
		# Generate text to count
		frequency = {}

		wordstring = wordstring.lower()
		wordlist = re.findall(r'\b[a-z]{3,15}\b', wordstring)
		#wordlist= re.sub(r'\W+', ' ', wordlist)
		wordfreq = [wordlist.count(w) for w in wordlist]
		"""
		wordlist.sort()
		wordlist.reverse()
		wordfreq.sort()
		wordfreq.reverse()
		"""
		#TODO
		#print ('\n'.join(getUniqueItems(list(wordlist))))
		kelimeSayisi=0

		for a in wordlist:
			kelimeSayisi = kelimeSayisi+1
			#if (kelimeSayisi <=5):
				#print((kelimeSayisi),a, sep=" : ")
				
		#print("String\n" + wordstring +"\n")
		#print("Wordlist\n" ,wordlist , "\n")
		#print("List\n" + str(wordlist) + "\n")
		#print("Frequencies\n" + str(wordfreq) + "\n")
		#print("Pairs\n" + str(zip(wordlist, wordfreq)))
		#print(type(wordstring))
		#print(type(str(wordlist)))
		#print(type(wordfreq))
		#print(type(str(wordfreq)))
		#print(type(str(zip(wordlist, wordfreq))))
		#print(type(zip(wordlist, wordfreq)))
		x=1
		lineData=[]
		os.remove("output/tf_list.csv")
		out = csv.writer(open("output/tf_list.csv","a"),delimiter='\n')
		for x in range(1, 50):
			line = (mit.nth(wordlist, x),",",str(x),"\n" )
			out.writerow({line})
			lineData.append(mit.nth(wordlist, x))
			lineData.append("\n")
		wordCloudText = ''.join(lineData)
		print(wordCloudText)
			
			

		
# Display the generated image:
# the matplotlib way:

#plt.imshow(wordcloud, interpolation='bilinear')
#plt.axis("off")

# lower max_font_size
	wordcloud = WordCloud(background_color = 'white',width = 1200,height = 1000,
				color_func = random_color_func).generate(wordCloudText)
	f = plt.figure()
	plt.imshow(wordcloud, interpolation="bilinear")
	plt.axis("off")
	plt.show()
	f.savefig("output/tf_wordCloud.pdf", bbox_inches='tight')

# The pil way (if you don't have matplotlib)
# image = wordcloud.to_image()
# image.show()
	
"""MAIN"""

if __name__ == '__main__':

	main()
