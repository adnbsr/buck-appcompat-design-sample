import re
import os
import urllib
import requests


def get_file_url(group, name, version, ar):
    return 'http://repo1.maven.org/maven2/{0}/{1}/{2}/{1}-{2}.{3}'.format(group.replace('.', '/'), name, version, ar)


def get_jar(group, name, version, ar):
    check_third_party()
    r = requests.get(get_file_url(group, name, version, ar))

    with open("third-party/{name}-{version}.{ar}".format(name=name, version=version, ar=ar), "wb") as file:
        file.write(r.content)

    print "Downloading :", name


def check_third_party():
    if not os.path.exists('third-party'):
        print ('third-party does not exists!!! \ncreating folder : third-party')
        try:
            os.makedirs('third-party')
        except OSError:
            pass


def check_maven_sha1(group, name, version, ar):
    try:
        link = get_file_url(group, name, version, ar) + '.sha1'
        f = urllib.urlopen(link)
        cksum = f.read()
        int(cksum, 16)
        return cksum
    except ValueError:
        return None


def check_file_exists(name, version, ar):

    path = "third-party/{name}-{version}.{ar}".format(name=name, version=version, ar=ar)

    if not os.path.exists(path):
        return False
    else:
        return True


def maven(repo):
    group, name, version = repo.split(':', 3)

    for ar in ['aar', 'jar']:
        cksum = check_maven_sha1(group, name, version, ar)
        if cksum is not None:
            if not check_file_exists(name, version, ar):
                get_jar(group, name, version, ar)







