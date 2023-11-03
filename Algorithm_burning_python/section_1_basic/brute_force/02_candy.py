candy = int(input())									# ex) 6개

answer = 0
for A in range(0, candy + 1):							# 0 ~ 6
	for B in range(0, candy + 1):						# 0 ~ 6
		for C in range(0, candy + 1):					# 0 ~ 6
			if (A + B + C == candy):
				if (A >= B + 2):
					if (A != 0 and B != 0 and C != 0):
						if (C % 2 == 0):
							answer += 1
print(answer)
