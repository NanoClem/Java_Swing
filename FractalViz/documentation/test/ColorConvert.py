

def ConvertNumHex(num = 0, prev = '') :
    list    = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F']
    nb      = int(num+1)
    hexList = ['0']
    hexStr  = prev

    while nb > 16 :
        nb = nb-16
        if(hexList[0]!='F') :
            hexList[0]=list[list.index(hexList[0])+1]

    hexList.append(list[nb-1])
    for a in hexList :
        hexStr = hexStr + a

    if num <= 255 and num >= 0 :
        return hexStr



def ColorRVBHex(rvb=(0,0,0)) :
    color_hex = ConvertNumHex(rvb[0],'#')+ConvertNumHex(rvb[1])+ConvertNumHex(rvb[2])
    return color_hex
